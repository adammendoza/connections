import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
// import org.apache.commons.codec.binary.Base64;

import java.net.*;
import java.util.*;
import java.io.*;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/*
this.httpClient = new httpClient(connectionManager);
this.httpClient.getparams().setAuthenticationPreemptive(true);
String userName = ""


Credentials defaultCreds = new UsernamePasswordCredentials(userName, password);
this.httpClient.getState().setCredentials(AuthScope.ANY, defaultCreds);
Protocol noAuthHttps = new Protocol("https", (ProtocolSocketFactory)new EasySSLProtocolSocketFactory(), 443);
Protocol.registerProtocol("https", noAuthHttps);
8*/


public class cmx_parser
{

	public static void get_cmx()
	{
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
      		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        		return null;
      		}
      		public void checkClientTrusted(X509Certificate[] certs, String authType) {
      		}
      		public void checkServerTrusted(X509Certificate[] certs, String authType) {
      		}
    		} };
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    		URL url = new URL("https://10.10.20.21/api/contextaware/v1/location/clients");
			HttpURLConnection myURLConnection = (HttpURLConnection)url.openConnection();
			String basicAuth = "Basic " + "ZGV2dXNyOmRldnVzcg==";
			myURLConnection.setRequestProperty ("Authorization", basicAuth);
			myURLConnection.setRequestMethod("GET");
			myURLConnection.setRequestProperty("Content-Type", "text/xml");
			myURLConnection.setRequestProperty("Content-Language", "en-US");
			myURLConnection.setUseCaches(false);
			myURLConnection.setDoInput(true);
			myURLConnection.setDoOutput(true);
   			String code = String.valueOf(myURLConnection.getResponseCode());
   			System.out.println("Error code "+code);
   			// InputStream is = myURLConnection.getInputStream();

   			// BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
   			// String line;
   			// while ((line = bufferedReader.readLine()) != null) {
     	// 		System.out.println(line);
   			// }
		} catch (Exception e) {
    		e.printStackTrace();
		}
	}

    public static void main(String []args) {
    	get_cmx();
       System.out.println("Hello World");
    }
}