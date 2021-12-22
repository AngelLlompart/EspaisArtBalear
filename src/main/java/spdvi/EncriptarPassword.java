package spdvi;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class EncriptarPassword{
  public static String Md5encode(String str) {
    return DigestUtils.md5Hex(str);
  }
  
  public static String Base64encode(String str) {
    byte[] b = Base64.encodeBase64(str.getBytes(), true);
    return new String(b);
  }
  
  public static String Base64decode(String str) {
    byte[] b = Base64.decodeBase64(str.getBytes());
    return new String(b);
  }
  
  public static String SHA1encode(String str) {
    return DigestUtils.sha1Hex(str);
  }
}