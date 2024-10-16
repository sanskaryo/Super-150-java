public class trappedWater {
    


 
        public int trap(int[] height) {
    
            int left = 0, right = height.length - 1;  
            int leftMax = height[left], rightMax = height[right];  
            int waterTrapped = 0;  
    
            while (left < right) {  
                if (leftMax < rightMax) {  
                    left++;  
                    leftMax = Math.max(leftMax, height[left]);  
                    waterTrapped += leftMax - height[left];  
                } else {  
                    right--;  
                    rightMax = Math.max(rightMax, height[right]);  
                    waterTrapped += rightMax - height[right];  
                }  
            }  
    
            return waterTrapped;  
        
            
        }
    }
