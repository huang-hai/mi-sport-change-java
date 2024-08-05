package cc.niushuai.projects.misportchange.stepchange;

import cc.niushuai.projects.misportchange.stepchange.bean.MiUser;
import cc.niushuai.projects.misportchange.stepchange.service.StepChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
public class SystemRun {

    @Autowired
    private StepChangeService stepChangeService;

    private String appid = "wx8d149d9134798e7b";
    private String appsecret = "acd52eca7b61d4fb82821a9ad3cdae53";

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
}
