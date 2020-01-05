package search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import org.junit.Test;

/**
 * 符号表用例
 */
public class FrequencyCounter {
    public static void main(String[] args) {
        In in = new In("tinyTale.txt");
        ST<String, Integer> st = new ST<>();
        int minlen = 1;
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() < minlen) continue;
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }
        String max = "";
        int maxQuantity = 0;
        for (String word : st.keys()) {
            if (st.get(word) > maxQuantity) {
                max = word;
                maxQuantity = st.get(word);
            }
        }
        System.out.println(max + "  " + st.get(max));

//        System.out.println(s);
    }

    @Test
    public void test1() {
        String url = "https://algs4.cs.princeton.edu/31elementary/leipzig1M.txt";
//        String s = MyHttpUtil.clientGet(url, "");
//        System.out.println(s);
    }
//    public static String sendPost(String url, String param,String contentType) {
//        PrintWriter out = null;
//        BufferedReader in = null;
//        String result = "";
//        try {
//            URL realUrl = new URL(url);
//            // 打开和URL之间的连接
//            URLConnection conn = realUrl.openConnection();
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Accept-Charset", "UTF-8");
//            if(contentType!=null && contentType.length()>0){
//                conn.setRequestProperty("Content-Type", contentType);
//            }
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
//            // 发送请求参数
//            out.print(param);
//            // flush输出流的缓冲
//            out.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("发送 POST 请求出现异常！" + e);
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输出流、输入流
//        finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (in != null) {
//                    in.close();
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return result;
//    }
}
