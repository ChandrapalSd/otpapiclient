package in.gov.uidai.otpapiclient;

import in.gov.uidai.otpapiclient.model.OtpRes;

/* import java.util.Scanner; */
import java.util.UUID;

public class OtpAPIClientMain {

    public static void main(String[] args) throws Exception {
        OtpAPIService otpAPIService = new OtpAPIService();
        otpAPIService.readProperties();
        String txnId = UUID.randomUUID().toString();
//        System.out.println("Printing txnId: " + txnId);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter UID");
//        String uid = scanner.nextLine();
        if(args.length <1){
            System.out.println("{\n\"result\": \"n\",\n\"txnId\": \"" + txnId +"\",\n\"err\": \"0\"\n}");
            System.exit(0);
        }
        String uid = args[0];
        OtpRes otpRes = otpAPIService.getOtpRes(uid,txnId);
        System.out.println("{\n\"result\": \"" + otpRes.getRet().value() + "\",\n\"txnId\": \"" + txnId + "\",\n\"err\": \"" + otpRes.getErr()+"\"\n}");
    }

}
