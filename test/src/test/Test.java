package test;
import java.util.Map;


public class Test {
    public static void main(String[] args) {
        String originText = "abcdacaha";
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.setDebug(true);//测试
        String binary = huffmanTree.encode(originText);
        byte[] bytes =binary.getBytes();
        Map<String, Character> codeTable = huffmanTree.getCodeTable();
        int lastByteNum = binary.length() % 8;
        System.out.println(bytes.length);
        //将bytes、codeTable、 lastByteNum传递到服务器端
        //省略。。。。。。

        /*
                         服务器端解析
                         接收到参数，并转换成bytes、relationMap、 lastByteNum
        */
        
      
        
        String fullBinary =new String(bytes, lastByteNum);
        System.out.println("服务器二进制："+fullBinary);
        String retrieveText = huffmanTree.decode(codeTable, fullBinary);
        System.out.println("恢复文本："+retrieveText);
    }
}
