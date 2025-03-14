public class Asteroids_735 {



    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (Math.abs(ast) > stack.peek()) {
                    stack.pop(); // Destroy the top asteroid
                    continue; // Continue checking for more collisions
                } else if (Math.abs(ast) == stack.peek()) {
                    stack.pop(); // Both asteroids destroy each other
                }
                destroyed = true; // Current asteroid is destroyed
                break;
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}



    
