
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ValidTableLink extends ValidLink {

    private static Vector<String> existTableList = new Vector<>();
    private static String [] existTableLinkList;

    public ValidTableLink() {

    }

    public ValidTableLink(Vector<String> existList, String [] existLinkList, Vector<String> existTableList, String [] existTableLinkList) {
        super(existList, existLinkList);
        ValidTableLink.existTableList = existTableList;
        ValidTableLink.existTableLinkList = existTableLinkList;
    }

    public Vector<String> getExistTableList() {
        return existTableList;
    }

    public String [] getExistTableLinkList() {
        return existTableLinkList;
    }

    public void existTableLink() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        for (int b = 0; b < getExistList().size(); b++) {
            String [] existLink = getExistLinkList();
            CheckValidTable link2 = new CheckValidTable(existLink[b]);
            Future<String> future = service.submit(link2);
            try {
                if (future.get() != null) {
                    String existTableLink = future.get();
                    existTableList.add(existTableLink);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        existTableLinkList = new String[existTableList.size()];
        existTableList.copyInto(existTableLinkList);
        /*for (int a = 0; a < existTableLinkList.length; a++) {
            System.out.println("Valid Link(Table) "+(a+1)+" : "+existTableLinkList[a]);
        }*/

        service.shutdown();
    }
}
