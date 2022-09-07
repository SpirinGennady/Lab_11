public class Main {
    public static void main(String[] args) throws Exception {
        Thread accountant = new AccountantThread();
        Thread sleeper = new SleeperThread();
        System.out.println("������ ���������������");
        accountant.start();
        sleeper.start();

        Thread.sleep(500L);
        System.out.println("Interrupting thread");
        accountant.interrupt();
        sleeper.interrupt();
        
        System.out.println("Joining thread");
        accountant.join();
        sleeper.join();
        
        System.out.println("�� ������!");
    }
    private static class AccountantThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                if (i % 10 == 0)
                    System.out.println( i + " ������� �� 10 ��� �������");
            }
        }
    }
    private static class SleeperThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(500L);

            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}
