/**
 * Created by benjaminzhang on 19/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class StringUtil{
    /*
     * 计算字符串的字节长度(字母数字计1，汉字及标点计2)
     *
     */
    private int byteLength(String string){
        int count = 0;
        for(int i=0;i<string.length();i++){
            if(Integer.toHexString(string.charAt(i)).length()==4){
                count += 2;
            }else{
                count ++;
            }
        }
        return count;
    }

    /*
     * 按指定长度，省略字符串部分字符
     * @para String 字符串
     * @para length 保留字符串长度
     * @return 省略后的字符串
     */
    protected String omitString(String string,int length){
        StringBuffer sb = new StringBuffer();
        if(byteLength(string)>length){
            int count = 0;
            for(int i=0;i<string.length();i++){
                char temp = string.charAt(i);
                if(Integer.toHexString(temp).length()==4){
                    count += 2;
                }else{
                    count++;
                }
                if(count<length-3){
                    sb.append(temp);
                }
                if(count==length-3){
                    sb.append(temp);
                    break;
                }
                if(count>length-3){
                    sb.append(" ");
                    break;
                }
            }
            sb.append("...");
        }else{
            sb.append(string);
            for (int i = 0; i < length - byteLength(string); i++) {
                sb.append("  ");
            }
        }
        return sb.toString();
    }
}