package hw;

public class WellFormedExpression {
	static boolean isWellFormed(String s) {
		/**** Create a stack for Characters ****/
		char ch;
		MyStack stack = new MyStack();
		for(int i=0; i<s.length();i++) {
			ch = s.charAt(i);
//			System.out.println(ch);				
			/************************************************
			 if ch is a opening bracket, then push it to the stack
			 else if ch is a closing bracket
					if stack is empty, return false
					if stack.pop() does not match the closing bracket, return false
			 else ignore (do nothing)
			 
			 Assume that only three kinds of brackets are used - (), {}, []
			************************************************/
			if (ch == '(' || ch == '[' || ch == '{')
				stack.push(ch);
			else if (ch == ')' || ch == ']' || ch == '}')
			{
				if ((stack.peek() == null) ||
					((char)stack.peek() == '(' && ch != ')') || ((char)stack.peek() == '[' && ch != ']') || ((char)stack.peek() == '{' && ch != '}'))
					return false;
				stack.pop();
			}
		}
		// Here all characters are read. The stack should be empty to return true.
		return (stack.peek() == null); // change this to your need.
	}
	public static void main(String[] args) {
		// Example of using MyStack for Character
//		MyStack<Character> st = new MyStack<Character>();
//		st.push('a');
//		st.push('b');
//		System.out.println(st.pop());
//		System.out.println(st.isEmpty());
//		System.out.println(st.pop() == 'a');
		
		System.out.println(isWellFormed("(ab)")); // good
		System.out.println(isWellFormed("(1+2)[]{3* 4}")); // good
		System.out.println(isWellFormed("([]){}")); // good
		System.out.println(isWellFormed("(((())))")); // good
		System.out.println(isWellFormed("]")); // bad
		System.out.println(isWellFormed("( xx [xxx) xx]")); // bad
		System.out.println(isWellFormed("(()")); // bad
		System.out.println(isWellFormed("())")); // bad
	}
}