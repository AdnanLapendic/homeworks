package Task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to create one map with Integer Key and ArrayList in Value.
 * @author Adnan Lapendic
 *
 */
public class MapInt {

	public static void main(String[] args) {

		Map<Integer, ArrayList<Integer>> map = getMap(3, 5);
		System.out.println(map);

	}
	public static Map<Integer, ArrayList<Integer>> getMap(int keyLimit,
			int valueLimit) {
		//Initializing new map with Integer Key, and ArrayList Value
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		//number of Keys 
		for (int i = 1; i < keyLimit + 1; i++) {
			//adding new ArrayList for each Key
			ArrayList<Integer> tmpList = new ArrayList<Integer>();
			for (int j = 0; j < valueLimit; j++) {
				tmpList.add(i * j + 1);
			}
			map.put(i, tmpList);
		}
		return map;
	}

}
