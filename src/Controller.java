import java.awt.List;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private Model model;
    private View view;

    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
    }

	public Map<Integer, Integer> countRepeats(ArrayList<Integer> arrList) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		arrList.forEach(key -> {
		if(map.containsKey(key)){
			int value = map.get(key);
			map.replace(key, ++value);
		}
		else{
			map.put(key, 1);
		}});
		return map;
	}

	public void testList() {
		Integer[] arr = new Integer[4];
		CustomList<Integer> clist = new CustomList<Integer>(arr);
		clist.add(5);
		clist.add(2);
		clist.set(1, 6);
		System.out.println(clist.toString());
		System.out.println(clist.size());
		//clist.remove(1); 			//Exception
		
	}

}