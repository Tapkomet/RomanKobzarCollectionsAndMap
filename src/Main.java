import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(view, model);

        Map<Integer, Integer> map;
        map = controller.countRepeats(GlobalConstants.arrList);
        view.printMessage(map.toString());
        
        controller.testList();
    }
}