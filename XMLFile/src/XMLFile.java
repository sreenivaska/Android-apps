
public class XMLFile {

	private String str;
	public static void main(String []args){
		String name="XXX";
		String lname="YYY";
		String contact ="33333";
		String email= "x@y.com";
		String deviceID="WWWWWWWWW";
		StringBuilder sb;
		
		sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("\n");
		sb.append("<ServiceRequest>");
		sb.append("\n");
		sb.append("<ServiceRequestHeader id=\"0\" deviceID=\""+deviceID +"\" />");
		sb.append("\n");
		sb.append("<ServiceRequestBody>");
		sb.append("\n");
		sb.append("<NV name=\"userName\" value=\"\" />");
		sb.append("\n");
		sb.append("<NV name=\"versionName\" value=\"PasswdMgr\" />");
		sb.append("\n");
		sb.append("<NV name=\"versionDate\" value=\"08-16-2010\" />");
		sb.append("\n");
		sb.append("<NV name=\"emailID\" value=\" "+ email+" \" />");
		sb.append("\n");
		sb.append("<NV name=\"firstName\" value=\" "+ name +" \" />");
		sb.append("\n");
		sb.append("<NV name=\"lastName\" value=\" "+ lname+" \" />");
		sb.append("\n");
		sb.append("<NV name=\"contactNumber\" value=\" "+ contact+" \" />");
		sb.append("\n");
		sb.append("</ServiceRequestBody>");
		sb.append("\n");
		sb.append("</ServiceRequest>");
		String xmlStr = new String(sb);
		System.out.println(xmlStr);
			
	}

}
