import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RoughAnindya {

	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 11, 12, 13, 15, 19 };
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		for (int i = 1; i <= 20; i++) {
			if (!list.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
