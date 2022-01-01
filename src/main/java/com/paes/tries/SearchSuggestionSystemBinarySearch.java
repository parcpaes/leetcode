package com.paes.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;

public class SearchSuggestionSystemBinarySearch {
    public static int binarySearchPrefix1(String[] products, String prefix,int lower, IntPredicate compareTo){
        if(prefix.isEmpty()) return -1;
        int low=lower, high=products.length-1,len;
        while(low<=high){
            int mid = (low+high)>>1;
            len = Math.min(prefix.length(), products[mid].length());
            int comp = products[mid].substring(0,len).compareTo(prefix);
            if(compareTo.test(comp)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        high=high+1;
        if(low>=0 && high<=products.length && low==high) return low;
        return -1;
    }

    public static int binarySearchPrefix(String[] products, String prefix){
        if(prefix.isEmpty()) return -1;
        int low=0, high=products.length-1,len;
        while(low<=high){
            int mid = (low+high)>>1;
            len = Math.min(prefix.length(), products[mid].length());
            int comparator = products[mid].substring(0,len).compareTo(prefix);
            if(comparator<0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        high=high+1;
        if(low>=0 && high<=products.length && low==high) return low;
        return -1;
    }
    public static int getMostThreeLeftIndex(String[] products,int lower,String prefix){
        int index=lower;
        for (int i=0;i<3 && index<products.length;i++){
            int len = Math.min(prefix.length(),products[index].length());
            if(prefix.length()>products[index].length()) return index;
            int comparator=products[index].substring(0,len).compareTo(prefix);
            if(comparator==0) index++;
        }
        return index;
    }
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        StringBuilder sb = new StringBuilder();
        List<List<String>> result = new ArrayList<>();
        int i;
        for(i=0;i<searchWord.length();i++){
            sb.append(searchWord.charAt(i));
            int lower = binarySearchPrefix(products,sb.toString());
            int upper=getMostThreeLeftIndex(products,lower,sb.toString());
            if(lower>=0 && upper>=0){
                int len=upper-lower;
                String[] matches = new String[len];
                System.arraycopy(products,lower,matches,0,len);
                result.add(List.of(matches));
            }else{
                break;
            }
        }
        if(i<searchWord.length()) {
            result.addAll(Collections.nCopies(searchWord.length() - i, new ArrayList<>()));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = {"ilpxatcgvfbmfunpljkodnbfaowi","ilpsokmmniywxgbeqrpsaqeqn","talrnwemajlqicbkxjyf","sbqhbuvkvntmsutdpyavojqwinxofhvhecbtjjkwdkaazftxvgvicgio","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiameutvrtqwucjp","l","ilpxywtmdnlil","rnjutrkyojwumoyrgzx","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyrhxnvfqsuymujmvkwctobnuvrusbqt","ilpxatcgvfblxfvbnoxgmmpvqqvxqyuecwpbjtlzwmmcwspztjjxevjpxdnzcectypljpkjoilnvur","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdkwrfizkvef","ffngjbmfkxtstjbzalnutfiybfy","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaipwtaovnfhuzu","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuamwsmzfbbtgnfsbujeotpndobpdg","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbl","ilpxatcfeexjqxghbengdcvsljajqaxidzitqjfjpovxmijvofntfelqidcbekzecqodiralswkjqckrpz","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrklmagbqeadtwhndgodzgfejjcs","hp","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxovkmfvxdiuceqbvczetytkfvcfykt","ktihatqubvuvnszewdlcyfqclgwhwsrawtcpdvxwhmvaftzkrvu","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexgkoeppszhfbajvcxuaplxeobzyqe","ilpxatcgvfblxfvbnoxgmmpvdxthphkvtcfhpevifbuzgcmxqjvtukbgeppeaufwgjbdfppxwszavitpctqthp","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqzxnhaplrwcgwjkr","ilpxatcgvfkvqfnblpdvtesdandbeynurlcjwwrellxigbsfjccihrvfbsbtcscblctnzededcajrywkj","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypexgkrbzdzmsbimuycjfk","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirysflyamgemsnjibnfxbke","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetvkcqmhquleujnmi","edmasudelavobnlbrj","zgjrwqhoqvmaaasqmggcuahifrwwrfrtpvchkuvncpvugmizhpfiokijxwlssapntpecbdgwteqvfdzwu","ilpxatcgvfblxfvbnoxgmmpvimowoccdedopz","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwhchcgi","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdtdvk","lnpadggtvd","xbnfiostesudukxgghwolzawxqlovbnjweddrqcisujmuhsazvetxrsyqdaidrmfomwmanghqn","zgmmrzerbzujlgomosxmgihordwpzvbnywczhosikslzlaqfyqnrjfbqzqwvihzojyzswbdxczknclmuyhdc","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamclkswqd","gdqdyysurpvmakyesqoeipuvxlhnffgemhvswyvkbgatxuufhbuitjwnvvigwfweiordqdhtnzagjputzale","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaxcp","ilpxatcgvfblxfvbnoxgmmkmnlolyewtuuosejmgconmcjep","ilpxatcgvfblxfvbnoxgmmpvimowocjrj","ilpxatcgvfblxfvbnoxgmmpvimowoccbsqkdevdkizvlnrl","wyeisnjhrhossmnpnexjqbkcsorccgawfgifsmwfdqqadgqdgpfoiagyxperbshwzbnoqqyjr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcmsdqhbizk","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdqlhdjfflb","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxiedjqmul","tzkwqsmwdhczbqnimbzgguyqvtywcyzkqhnkdtknumpuikfexldysotnndztwootn","ilpxatcsfwrpusskcsmzunvejmfymcvs","usoaljtodfybvquycywtnvivvdvbvymivvc","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiobdewutljgvugibawjskriuxeiwishfimbsinzt","orrcvinutuqbzlaxrfhsbpjoonsjrubyrbbdghhqnwjz","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqncvydjmnouqktixtgjtvkmwciiuso","jponpctybxuxtnigdqortyqjiobgdaehgybozbtvxalhyubibburfsjukhalynnkvjr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofpsbqljapaqco","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaegtshdqrhtimpvnbymwrlmvghl","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxgcyqcrmwlrjlbnqqfuhypqgiurkyapxzrdsnbeifik","ilpxatcgvfblxfvbnoxgmmiiubtvodpzwgdgoobsbbnlfjldpqydwejvfysrwhmhg","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqp","dpwgvxdrbzlh","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpufytsqrkyhiehtjkgohchjkmxcx","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiiwstxiirty","irjbjafrvdcpqanwt","ilpxatcgvn","ilpxatcgvfblxfvbnoxuherdhypducgxsuftiappkjfcqvorxizvdlgswfrqveuhlzitltnushzs","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrypwuijbjublekmxhchhnaxbhbgdaqifvdrfvheqiqcswrskd","ilpxatcgvtqdvgovjgabbmkdicgymudbikvhihpxfmpanjyp","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamiuzrrvibhkwigjgrqfhn","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlym","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqismi","jtbuygbbtdyasdtcuswpbquuhswfciyndfton","ilpxxishsvmt","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvfgdtlfrwklzcwqmbmefnxwrtkpak","ilpxatcgvfblxfvbnoxgmmpvimowoumiglwjrzletaydenogpldiblrwpyjeqjeow","hlwga","ilpxatcgvfblxfvbnjyryxxfayspcrqkvyopfzspzmmhhalwjvfhsgybgkzctlqtr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofewrprmowynq","qyuthohyzttitkgfrfybiuuvzzcqbddrbby","uinnxgnuuptrxhbhplcdklstqbamsxwaeubppeutqlgngtgzycxpcqjabucoi","ilpxatcgvfblxfvrpbuumlvymcimuothjdhlsgenxxcllwfibvvcavuiuesgdjhsgoxjzechjhwnprmut","btrvkwzfdovyyycfxwmxhutvldkblvrsmeyktlwnmdmdepjnkrzkmnerxesvycbrpghnf","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycltcndobbsywuhxohkzostnacjyhj","dijc","ilpxatcgvfblxfvbnoxgmmpvimowoccdednjkkgwtekjv","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcwqxooniui","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyuhbnoibkpmygmul","potullxiksrpnhngusckddvrtylgwztzxmmgvtrlbgwkgbgohsgbljroghmpwrwupszmkv","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoqpodgpsgmlj","ryfoisftsawa","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqexqy","fzvfyiqrwbserbdnnymmcaokpasfpijvbwdxnbctzekkgcudayqlnsclgcxkaeslihczwxphyqbdyxthpuprxjb","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpvoltdohcmslq","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdeyozknywbktmyzkm","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqlc","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypsan","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiarrqyflykjdwvnvicearpou","yfilpbgdkfmphopolcvjbemkpqcqvcxdkkolpwgco","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztckwzvayxyzaqpm","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywb","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaisnakhppbhnofpnuns","khdyqeswcmriitjysdj","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpnupiwbdseowsrurzjiscnitdqncuyzxvkuiskezqy","ilpxatcgvfovxvhriwhgpadztzfcdfgnhktkhqhjiueszhzjpmxrzfgccxovsqxo","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnvncgupn","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetabyivtjxivaraiwg","zvtcdlbjbnlnadytwqwrnbjomdlmmujvwpmazwbjwippucsujioeevltrrdfivkamxgjtrqckuflvpnbsbrhda","apkqpncsbbiqstfxplizqbpriqywwjiwquzpfyhwyxfcucwcs","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetjoolenqclkstqazwb","bjvozgbmtqdxyfirqwhebtijcwrebvdkxtxoahqsjtofybvh","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukfuxkg","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycqgxdkpnisqsfzlkmnpstbd","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrwh","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkygsrgv"};
        String searchWord = "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywrywcjmtvaleckwduejlayguredkubbcqhtiafhcsmlgdmpcdouxdyxykmujehtpkjqfbrbyehjcnymgumqwbfouubonhzhvssjmpudpvjtdlurkbwyahtclafjaztcdxstgpsvhbbyndqhfkyycxnrvitcasubhnaeolgmmmedgzqtpjjhtlkwqcnjgwehbriwiklwniobbzhegbisgwccvstmdqyneolakaakrnzhmczxdoxhelbezsggbrzlzrrecyvzvrteofqopamraasigegtovcspphlpmsxsfkouohlwdvgrttzltyojunyvmlmhjjihubmkkbrvsbbdiejimobknxcwntoaqltofqopslhzobiuqhlxivctogflejhdlulda";
        List<List<String>> result = suggestedProducts(products,searchWord);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }
}
