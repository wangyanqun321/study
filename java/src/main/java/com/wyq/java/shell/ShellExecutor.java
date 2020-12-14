package com.wyq.java.shell;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @author 王艳群
 * @description ShellExecutor
 * @date 2020/8/20
 */
public class ShellExecutor {

    public static void main(String[] args) throws Exception {
        ShellExecutor shellExecutor = new ShellExecutor();
        shellExecutor.service("hello.sh");
    }

    public void service(String shellName) throws Exception{
        String shellDir;
        String shellPath;
        try {
            //获取脚本所在的目录
            shellDir = "/home";
            //拼接完整的脚本目录
            shellPath = shellDir + "/shell/" + shellName;
            System.out.println("shell path = " + shellPath);
            //执行脚本
            callScript(shellPath);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 脚本文件具体执行及脚本执行过程探测
     * @param script 脚本文件绝对路径
     * @throws Exception
     */
    private void callScript(String script) throws Exception{
        try {
            String cmd = "sh " + script;

            //启动独立线程等待process执行完成
            CommandWaitForThread commandThread = new CommandWaitForThread(cmd);
            commandThread.start();

            while (!commandThread.isFinish()) {
                Thread.sleep(1000);
            }

            //检查脚本执行结果状态码
            if(commandThread.getExitValue() != 0){
                throw new Exception("shell " + script + "执行失败,exitValue = " + commandThread.getExitValue());
            }
        }
        catch (Exception e){
            throw new Exception("执行脚本发生异常,脚本路径" + script, e);
        }
    }

    /**
     * 脚本函数执行线程
     */
    public class CommandWaitForThread extends Thread {

        private String cmd;
        private boolean finish = false;
        private int exitValue = -1;

        public CommandWaitForThread(String cmd) {
            this.cmd = cmd;
        }

        public void run(){
            try {
                //执行脚本并等待脚本执行完成
                Process process = Runtime.getRuntime().exec(cmd);

                //写出脚本执行中的过程信息
                BufferedReader infoInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader errorInput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line = "";
                while ((line = infoInput.readLine()) != null) {
                }
                while ((line = errorInput.readLine()) != null) {
                }
                infoInput.close();
                errorInput.close();

                //阻塞执行线程直至脚本执行完成后返回
                this.exitValue = process.waitFor();
            } catch (Throwable e) {
                exitValue = 110;
            } finally {
                finish = true;
            }
        }

        public boolean isFinish() {
            return finish;
        }

        public void setFinish(boolean finish) {
            this.finish = finish;
        }

        public int getExitValue() {
            return exitValue;
        }
    }

}
