package ly.hotupdate;

/**
 * Created by cilu on 2018/1/26.
 */

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

// 一个运行 Attach API 的线程子类
 class AttachThread extends Thread {

    private final List<VirtualMachineDescriptor> listBefore;

    private final String jar;

    AttachThread(String attachJar, List<VirtualMachineDescriptor> vms) {
        listBefore = vms;  // 记录程序启动时的 VM 集合
        jar = attachJar;
    }

    public void run() {
//        VirtualMachine vm = null;
        List<VirtualMachineDescriptor> listAfter = null;
        try {
//            int count = 0;
//            while (true) {
//                listAfter = VirtualMachine.list();
//                for (VirtualMachineDescriptor vmd : listAfter) {
//                    if (!listBefore.contains(vmd)) {
//                        // 如果 VM 有增加，我们就认为是被监控的 VM 启动了
//                        // 这时，我们开始监控这个 VM
//                        System.out.println(vmd.id());
//                        vm = VirtualMachine.attach(vmd);
//                        break;
//                    }
//                }
//                Thread.sleep(2000);
//                count++;
//                if (null != vm || count >= 10) {
//                    break;
//                }
//            }

        VirtualMachine vm = VirtualMachine.attach("2380");//args[0]传入的是jvm的pid号
//        //   vm.loadAgent("/Users/jiangbo/Workspace/code/java/javaagent/loadagent.jar");
            System.out.println(vm);
        vm.loadAgent(jar);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new AttachThread("D:\\Work\\Java\\SSM_Blog\\target\\test-classes\\ly\\hotupdate\\TestInstrument1.jar", VirtualMachine.list()).start();
    }
}