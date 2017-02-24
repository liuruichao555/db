package mysql;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Test1
 *
 * @author liuruichao
 * @date 15/9/18 上午11:09
 */
public class Test1 {
    public static void main(String[] args) {
        String customer = "sdjj";
        String key = "8472cf2c2f40fdebad0e3aba7c6eba65";
        //String key = "F147E7C235A898AC6A93C88B6CA5A92F4C549458";
        //String liveId = "55fa2e75f58356b6650029ca";
        String liveId = "55fa71fff58356b665002a3c";
        String user = "lcq";
        Long timestamp = System.currentTimeMillis();

        String url = "http://cache.upuday.com/student/index3.html?liveClassroomId=" + liveId
                + "&customerType=soooner&customer=" + customer + "&sp=0&p=";
        String _k = customer + timestamp + key + user + liveId;
        String k = DigestUtils.md5Hex(_k);
        //String k = MD5.getMD5(_k);
        String s = k.substring(0, 10) + k.substring(k.length() - 10);
        System.out.println(_k + "   " + k);
        String p = k + "|" + timestamp + "|" + user + "|" + user + "|1";
        System.out.println(url + p + "&s=" + s);
    }
}
