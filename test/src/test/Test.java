package test;
import java.util.Map;


public class Test {
    public static void main(String[] args) {
        String originText = "abcdacaha";
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.setDebug(true);//����
        String binary = huffmanTree.encode(originText);
        byte[] bytes =binary.getBytes();
        Map<String, Character> codeTable = huffmanTree.getCodeTable();
        int lastByteNum = binary.length() % 8;
        System.out.println(bytes.length);
        //��bytes��codeTable�� lastByteNum���ݵ���������
        //ʡ�ԡ�����������

        /*
                         �������˽���
                         ���յ���������ת����bytes��relationMap�� lastByteNum
        */
        
      
        
        String fullBinary =new String(bytes, lastByteNum);
        System.out.println("�����������ƣ�"+fullBinary);
        String retrieveText = huffmanTree.decode(codeTable, fullBinary);
        System.out.println("�ָ��ı���"+retrieveText);
    }
}
