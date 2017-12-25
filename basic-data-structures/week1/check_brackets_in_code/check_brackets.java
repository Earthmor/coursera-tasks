import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    public int getPosition(){
      return position;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
      InputStreamReader input_stream = new InputStreamReader(System.in);
      BufferedReader reader = new BufferedReader(input_stream);
      String text = reader.readLine();

      Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
      int bad_point = 0;
      for (int position = 0; position < text.length(); ++position) {
        char next = text.charAt(position);
        if (next == '(' || next == '[' || next == '{') {
          Bracket b = new Bracket(next, position + 1);
          opening_brackets_stack.push(b);
        }

        if (next == ')' || next == ']' || next == '}') {
          if(opening_brackets_stack.empty()){
            bad_point = position + 1;
            break;
          }
          Bracket b = opening_brackets_stack.pop();
          if(!b.Match(next)){
            bad_point = position + 1;
            break;
          }
        }
      }
      if(bad_point == 0 && !opening_brackets_stack.empty()){
        bad_point = opening_brackets_stack.pop().getPosition();
      }
      System.out.println(bad_point == 0 ? "Success" : bad_point);
    }
}
