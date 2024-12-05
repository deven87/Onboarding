package api.task1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Task01_HomeTask_Webservices_Functional {

	/**
	 * api end point
	 */
	public static final String SOAP_CALCULATOR_API_ENDPOINT = "http://www.dneonline.com/calculator.asmx";

	public static void main(String[] args)
			throws Exception {
		testOperation("add", 1, 2, 3);
		testOperation("subtract", 1, 2, -1);
		testOperation("divide", 1, 2, 0);
		testOperation("multiply", 1, 2, 2);

		// negative cases
		testOperation("divide", 5, 0, 0); // division by zero error is not correct
		testOperation("multiply", Integer.MAX_VALUE, 2, 0); // check out of range
		testOperation("subtract", -1, -2, 1);

	}

	/**
	 * testOperation
	 *
	 * @param operation      add subtract divide multiply
	 * @param operand1
	 * @param operand2
	 * @param expectedResult
	 * @throws Exception
	 */
	public static void testOperation(String operation, int operand1, int operand2, int expectedResult)
			throws Exception {

		switch (operation) {

		case "add":
			// read xml add payload
			String xmlDataForAdd = Files
			.readString(Paths.get(System.getProperty("user.dir"), "src", "api", "task1", "add.xml"));

			// replace operand placeholder in xml with actual values
			String soapRequestXmlAdd = xmlDataForAdd.replace("{{intA}}", String.valueOf(operand1)).replace("{{intB}}",
					String.valueOf(operand2));

			// get soap response by passing endpoint, xml and path parameter
			HttpResponse<String> addResponse = getResponse(SOAP_CALCULATOR_API_ENDPOINT, soapRequestXmlAdd, "Add");

			validateResponse(addResponse.body(), "AddResult", expectedResult);
			break;

		case "multiply":
			// read xml add payload
			xmlDataForAdd = Files
			.readString(Paths.get(System.getProperty("user.dir"), "src", "api", "task1", "mul.xml"));

			// replace operand placeholder in xml with actual values
			soapRequestXmlAdd = xmlDataForAdd.replace("{{intA}}", String.valueOf(operand1)).replace("{{intB}}",
					String.valueOf(operand2));

			// get soap response by passing endpoint, xml and path parameter
			addResponse = getResponse(SOAP_CALCULATOR_API_ENDPOINT, soapRequestXmlAdd, "Multiply");

			validateResponse(addResponse.body(), "MultiplyResult", expectedResult);
			break;

		case "divide":
			// read xml add payload
			xmlDataForAdd = Files
			.readString(Paths.get(System.getProperty("user.dir"), "src", "api", "task1", "div.xml"));

			// replace operand placeholder in xml with actual values
			soapRequestXmlAdd = xmlDataForAdd.replace("{{intA}}", String.valueOf(operand1)).replace("{{intB}}",
					String.valueOf(operand2));

			// get soap response by passing endpoint, xml and path parameter
			addResponse = getResponse(SOAP_CALCULATOR_API_ENDPOINT, soapRequestXmlAdd, "Divide");

			validateResponse(addResponse.body(), "DivideResult", expectedResult);
			break;

		case "subtract":
			// read xml add payload
			xmlDataForAdd = Files
			.readString(Paths.get(System.getProperty("user.dir"), "src", "api", "task1", "sub.xml"));

			// replace operand placeholder in xml with actual values
			soapRequestXmlAdd = xmlDataForAdd.replace("{{intA}}", String.valueOf(operand1)).replace("{{intB}}",
					String.valueOf(operand2));

			// get soap response by passing endpoint, xml and path parameter
			addResponse = getResponse(SOAP_CALCULATOR_API_ENDPOINT, soapRequestXmlAdd, "Subtract");

			validateResponse(addResponse.body(), "SubtractResult", expectedResult);
			break;

		default:
			System.out.println("Unsupported operation");
		}

	}

	/**
	 * validateResponse
	 *
	 * @param responseBody   http response body
	 * @param tagName        tag to validate
	 * @param expectedResult operation expected result
	 * @throws Exception
	 */
	public static void validateResponse(String responseBody, String tagName, int expectedResult)
			throws Exception {

		System.out.println(responseBody);
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new ByteArrayInputStream(responseBody.getBytes()));

		Node resultNode = document.getElementsByTagName(tagName).item(0);

		int actualResult = Integer.MIN_VALUE;

		if (resultNode != null) {
			try {
				actualResult = Integer.parseInt(document.getElementsByTagName(tagName).item(0).getTextContent());
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			if (expectedResult == actualResult) {
				System.out.println("Result correct, expected " + expectedResult + " actual " + actualResult);
			} else {
				System.out.println("Result not correct, expected " + expectedResult + " actual " + actualResult);
			}
		} else {
			System.out.println("Respone does not contain your result tag " + tagName);
		}
	}

	/**
	 * getResponse
	 *
	 * @param endPoint
	 * @param xml
	 * @param operation
	 * @return http response in string
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static HttpResponse<String> getResponse(String endPoint, String xml, String operation)
			throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPoint))
				.header("Content-Type", "text/xml; charset=utf-8")
				.header("SOAPAction", "http://tempuri.org/" + operation)
				.POST(HttpRequest.BodyPublishers.ofString(xml)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response;
	}

}
