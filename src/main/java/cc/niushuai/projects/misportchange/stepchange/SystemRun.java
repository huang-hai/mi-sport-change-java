package cc.niushuai.projects.misportchange.stepchange;

import cc.niushuai.projects.misportchange.stepchange.bean.MiUser;
import cc.niushuai.projects.misportchange.stepchange.service.StepChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

@EnableScheduling
@Component
public class SystemRun {

    @Autowired
    private StepChangeService stepChangeService;

    private String appid = "wx8d149d9134798e7b";
    private String appsecret = "acd52eca7b61d4fb82821a9ad3cdae53";

    private String sendKey = "SCT254885T1eIhetUYkjyGWRwTncqJo5n7";

    /**
     * 每天下午3点半提交步数
     */
    @Scheduled(cron = "0 30 12 * * ?")
    public void runSubmit(){
        MiUser user = new MiUser();
        user.setUsername("18120829818");
        user.setPassword("Huanghai4826");
        user.setStep(getStep());
        user.setStepType("MI");
        user.setTimeStamp(new Date().getTime());
        String res = null;
        try {
            res = stepChangeService.change(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StringBuffer sb = new StringBuffer();
        sb.append("phone：").append(user.getUsername());
        sb.append("step:").append(user.getStep());
        sb.append("res:").append(res).append("/n/n");

        System.out.println("18120829818:"+res);
        //Result result = Result.ok(res);
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        user.setUsername("13696830747");
        user.setStep(getStep());
        user.setTimeStamp(new Date().getTime());
        try {
            res = stepChangeService.change(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("13696830747:"+res);

        sb.append("phone：").append(user.getUsername());
        sb.append("step:").append(user.getStep());
        sb.append("res:").append(res);

        sendMsgToService(sb.toString());
    }

    private long getStep(){
        ////随机生成21000~25999的值
        int min = 21000;
        int max = 25999;

        double randomDouble = Math.random();


        return (long) (randomDouble * (max - min + 1) + min);
    }

    @Scheduled(cron = "50 11 19 * * ?")
    public void test(){
        System.out.println("定时器跑了。。。。。");
        long step = getStep();
        System.out.println("生成步数：" + step);
    }

    public void sendMsgToService(String desc){
        String title = "刷步通知";

        try {
            String url = "https://sctapi.ftqq.com/" + sendKey + ".send";
            String postData = "text=" + URLEncoder.encode(title, "UTF-8") + "&desp=" + URLEncoder.encode(desc, "UTF-8");


            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postData);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
