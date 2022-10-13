public class IP {
    public String networkAddress(String IP){
        int iMask=Integer.parseInt(IP.substring(IP.indexOf("/")+1));
        String[] table;
        String result = "";
        int [] iTable = new int[4];
        table=IP.split("[.]");
        table[3]=table[3].substring(0,table[3].indexOf("/"));
        for (int i=0;i<4;i++) {
            iTable[i] = Integer.parseInt(table[i]);
        }
        if (iMask%8 == 0) {
            for (int i = 3; i >= iMask / 8; i--) {
                iTable[i] = 0;
            }
        }  else {
            for (int i=3;i>=iMask/8;i--){
                if (iMask/8<i){
                    iTable[i]=0;
                } else {
                    int temp=255;
                    temp=~(temp>>>iMask%8);
                    System.out.println("maska: "+Integer.toBinaryString(temp));

                    temp=temp&255;
                    System.out.println("maska oczyszczona: "+Integer.toBinaryString(temp));
                    iTable[i]=iTable[i]&temp;  //iTable[i]=iTable[i]|(~temp)
                }
            }
        }
        result=result+iTable[0]+"."+iTable[1]+"."+iTable[2]+"."+iTable[3];
        return result;
    }

    public String broadcastAddress(String IP){
        int iMask=Integer.parseInt(IP.substring(IP.indexOf("/")+1));
        String[] table;
        String result = "";
        int [] iTable = new int[4];
        table=IP.split("[.]");
        table[3]=table[3].substring(0,table[3].indexOf("/"));
        for (int i=0;i<4;i++) {
            iTable[i] = Integer.parseInt(table[i]);
        }
        if (iMask%8 == 0) {
            for (int i = 3; i >= iMask / 8; i--) {
                iTable[i] = 255;
            }
        }  else {
            for (int i=3;i>=iMask/8;i--){
                if (iMask/8<i){
                    iTable[i]=255;
                } else {
                    int temp=255;
                    temp=~(temp>>>iMask%8);
                    System.out.println("maska: "+Integer.toBinaryString(temp));

                  //  temp=temp&255;
                    System.out.println("maska oczyszczona: "+Integer.toBinaryString(temp));
                    //iTable[i]=iTable[i]&temp;
                    System.out.println("Zanegowany temp "+Integer.toBinaryString(~temp));
                    iTable[i]=iTable[i]|(~temp);
                }
            }
        }
        result=result+iTable[0]+"."+iTable[1]+"."+iTable[2]+"."+iTable[3];
        return result;
    }

    public boolean checkIP(String IP1, String IP2){
        boolean result=true;
        String mask,mask2;
        String[] table1,table2;
        int t1,t2;
        int iMask=0;
        mask=IP1.substring(IP1.indexOf("/")+1);
        table1=IP1.split("[.]");
        System.out.println("split:"+table1[3]);
        table1[3]=table1[3].substring(0,table1[3].indexOf("/"));

        mask2=IP2.substring(IP2.indexOf("/")+1);
        table2=IP2.split("[.]");
        table2[3]=table2[3].substring(0,table2[3].indexOf("/"));

        if (!mask.equals(mask2)) { return false; }

        iMask = Integer.parseInt(mask);

        for (int i=0; i<(iMask/8);i++){
            if (!table1[i].equals(table2[i])) { return false; }
        }
        if (!((iMask/8)*8 == iMask)) {
            System.out.println("Analizuję oktet o wartosci :"+table1[iMask/8]);
            t1=Integer.parseInt(table1[(iMask/8)]);
            t2=Integer.parseInt(table2[(iMask/8)]);
            t1=t1>>8-(iMask-((iMask/8)*8));
            t2=t2>>8-(iMask-((iMask/8)*8));
            if(t1!=t2) { return false;}
        }
// iMask-((iMask/8)*8)

        System.out.println(mask);
        System.out.println(table1[3]);
        return true;
    }

}
