package util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang3.StringUtils;

public class RequestUtil {
	
	public static String requestPost(String contentType, String url, String data) throws Exception {
		/**  
         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using  
         *  java.net.URL and //java.net.URLConnection  
         *  
         *  使用页面发送请求的正常流程：在页面http://www.faircanton.com/message/loginlytebox.asp中输入用户名和密码，然后按登录，
         *  跳转到页面http://www.faircanton.com/message/check.asp进行验证
         *  验证的的结果返回到另一个页面
         *  
         *  使用java程序发送请求的流程：使用URLConnection向http://www.faircanton.com/message/check.asp发送请求
         *  并传递两个参数：用户名和密码
         *  然后用程序获取验证结果
         */  
        URL requesturl = new URL(url);   
        URLConnection connection = requesturl.openConnection();
        if(StringUtils.isBlank(contentType)){
        	connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");//
        }else{
        	connection.setRequestProperty("Content-Type", contentType);//"application/json; charset=utf-8"
        }
        connection.setReadTimeout(1000);
        connection.setConnectTimeout(1000);
        /**  
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。  
         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：  
         */  
        connection.setDoOutput(true); 
        /**  
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...  
         */  
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");   
        out.write(data); //向页面传递数据。post的关键所在！   
        // remember to clean up   
        out.flush();   
        out.close();   
        /**  
         * 这样就可以发送一个看起来象这样的POST：   
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:  
         * text/plain Content-type: application/x-www-form-urlencoded  
         * Content-length: 99 username=bob password=someword  
         */  
        // 一旦发送成功，用以下方法就可以得到服务器的回应：   
        InputStream l_urlStream;   
        l_urlStream = connection.getInputStream();   
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] tmpByte = new byte[1024*10];
        int count = l_urlStream.read(tmpByte);
        // 传说中的三层包装阿！   
        while (count > 0) {
        	byteArrayOutputStream.write(tmpByte, 0, count);
        	count = l_urlStream.read(tmpByte);
		}
		return new String(byteArrayOutputStream.toByteArray(),"utf-8");
	}
	
	public static String requestGet(String url, String data) throws Exception {
		/**  
         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using  
         *  java.net.URL and //java.net.URLConnection  
         *  
         *  使用页面发送请求的正常流程：在页面http://www.faircanton.com/message/loginlytebox.asp中输入用户名和密码，然后按登录，
         *  跳转到页面http://www.faircanton.com/message/check.asp进行验证
         *  验证的的结果返回到另一个页面
         *  
         *  使用java程序发送请求的流程：使用URLConnection向http://www.faircanton.com/message/check.asp发送请求
         *  并传递两个参数：用户名和密码
         *  然后用程序获取验证结果
         */  
        URL requesturl = new URL(url+"?"+data);   
        URLConnection connection = requesturl.openConnection(); 
        connection.setDoOutput(true); 
        /**  
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...  
         */  
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");   
        out.write(data); //向页面传递数据。post的关键所在！   
        // remember to clean up   
        out.flush();   
        out.close();   
        /**  
         * 这样就可以发送一个看起来象这样的POST：   
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:  
         * text/plain Content-type: application/x-www-form-urlencoded  
         * Content-length: 99 username=bob password=someword  
         */  
        // 一旦发送成功，用以下方法就可以得到服务器的回应：   
        InputStream l_urlStream;   
        l_urlStream = connection.getInputStream();   
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] tmpByte = new byte[1024*10];
        int count = l_urlStream.read(tmpByte);
        // 传说中的三层包装阿！   
        while (count > 0) {
        	byteArrayOutputStream.write(tmpByte, 0, count);
        	count = l_urlStream.read(tmpByte);
		}
		return new String(byteArrayOutputStream.toByteArray(),"utf-8");
	}
	
	public static String sendPost(String url, String param,String contentType) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			if(contentType!=null && contentType.length()>0){
				conn.setRequestProperty("Content-Type", contentType);
			}
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	public static InputStream requestGetObtainInputStream(String url, String data) throws Exception {
		/**
		 * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using
		 *  java.net.URL and //java.net.URLConnection
		 *
		 *  使用页面发送请求的正常流程：在页面http://www.faircanton.com/message/loginlytebox.asp中输入用户名和密码，然后按登录，
		 *  跳转到页面http://www.faircanton.com/message/check.asp进行验证
		 *  验证的的结果返回到另一个页面
		 *
		 *  使用java程序发送请求的流程：使用URLConnection向http://www.faircanton.com/message/check.asp发送请求
		 *  并传递两个参数：用户名和密码
		 *  然后用程序获取验证结果
		 */
		URL requesturl = new URL(url+"?"+data);
		URLConnection connection = requesturl.openConnection();
		connection.setDoOutput(true);
		/**
		 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
		 */
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
		out.write(data); //向页面传递数据。post的关键所在！
		// remember to clean up
		out.flush();
		out.close();
		/**
		 * 这样就可以发送一个看起来象这样的POST：
		 * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:
		 * text/plain Content-type: application/x-www-form-urlencoded
		 * Content-length: 99 username=bob password=someword
		 */
		// 一旦发送成功，用以下方法就可以得到服务器的回应：
		InputStream l_urlStream;
		return connection.getInputStream();
	}
}