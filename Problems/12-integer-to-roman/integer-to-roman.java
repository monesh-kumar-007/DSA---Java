class Solution {
    public String intToRoman(int num) {
        /* Map <Integer,String> dic = new LinkedHashMap<>();
        dic.put(1000, "M");
        dic.put(900, "CM");
        dic.put(500, "D");
        dic.put(400, "CD");
        dic.put(100, "C");
        dic.put(90, "XC");
        dic.put(50, "L");
        dic.put(40, "XL");
        dic.put(10, "X");
        dic.put(9, "IX");
        dic.put(5, "V");
        dic.put(4, "IV");
        dic.put(1, "I");

        StringBuilder romans = new StringBuilder();

        for(Map.Entry<Integer, String> entry : dic.entrySet()){
            int value = entry.getKey();
            String symbol = entry.getValue();

            while (num >= value){
                num -= value;
                romans.append(symbol);
            }        

        } 
        return romans.toString();
        
        */

        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder(15);

        for(int i = 0; i < value.length; i++){
            
            while (num >= value[i]){
                num -= value[i];
                roman.append(symbol[i]);
            }
        }

        return roman.toString();
    }

    
}