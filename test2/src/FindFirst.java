public class FindFirst {
    public static void main(String[] args) {
       //找出字符串中第一个只出现一次的字符
       String str = "abcdab";
       findFirst(str);
    }
    public static void findFirst(String str)
    {
        if(str == null){
            return;
        }
        int i = 0;
        char[] arr = str.toCharArray();
        int[] hashTable = new int[256];
        for(i=0; i<256; i++){
            hashTable[i] = 0;
        }
        char[] hashKey = arr;
        for(i=0; i<hashKey.length; i++){
            int tmp = hashKey[i];
            hashTable[tmp]++;
        }
        for(i=0; i<hashKey.length; i++){
            if(hashTable[hashKey[i]] == 1){
                System.out.println((char)hashKey[i]);
                return;
            }
        }
    }
}
