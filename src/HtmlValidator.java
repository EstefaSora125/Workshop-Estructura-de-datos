import java.util.Queue;
import java.util.Stack;

public class HtmlValidator{

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> newStack = new Stack<>();
		double tagsSize = tags.size();

		for (int i = 0; i < tagsSize; i++) {
			if (tags.element().isSelfClosing()) {
				tags.remove();
			} else if (tags.element().isOpenTag()) {
				newStack.add(tags.element());
				tags.remove();
			}else if (!newStack.isEmpty()){
				if (tags.element().matches(newStack.peek())) {
					newStack.pop();
					tags.remove();
				}
			}
			else {
				if (!tags.isEmpty() && !tags.element().isOpenTag()){
					return null;
				}
			}
		}
		return newStack;
	}
}
