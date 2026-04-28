import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequestToNumber {

    static String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd,inr,eur";

    static String[] ones = {
            "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static void apiRequestToNumber() throws Exception{

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        int inr = extractINR(body);
        System.out.println(numberToWords(inr));
    }//api

    public static int extractINR(String body) {
        int index = body.indexOf("inr");
        int start = body.indexOf(":", index) + 1;
        int end = body.indexOf(",", start);

        String inrValue = body.substring(start, end);
        System.out.println("Bitcoin INR Price : " + inrValue);
        return  Integer.parseInt(inrValue);
    }//inr

    public static String numberToWords(int num){
        String result = "";

        if(num >= 10000000){
            result += numberToWords(num / 10000000) + " Crore ";
            num %= 10000000;
        }

        if(num >= 100000){
            result += numberToWords(num / 100000) + " Lakh ";
            num %= 100000;
        }

        if(num >= 1000){
            result += numberToWords((num / 1000)) + " Thousand ";
            num %= 1000;
        }

        if(num >= 100){
            result += ones[num/100] + " Hundred ";
            num %= 100;
        }

        if(num >= 10 && num < 20){
            result += ones[num];
        } else if(num >= 20){
            result += tens[num/10] + " ";
            num %= 10;

            if(num > 0){
                result += ones[num];
            }
        } else if(num > 0){
            result += ones[num];
        }

        return result;
    }//numToWords

}//class