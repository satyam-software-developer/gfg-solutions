
   class Solution {
       public ArrayList<ArrayList<Integer>> formCoils(int n) {
           ArrayList<ArrayList<Integer>> result = new ArrayList<>();
           int nn = 4 * n;


           ArrayList<Integer> first=new ArrayList<>();
           int top=0;
           int bottom=nn-1;
           int right=nn-2;
           int left=0;
           while(top<=bottom&& left<=right){

               //left
               for(int i=top;i<=bottom;i++){

                   first.add( ((4*n*i) +left+1) );

               }
               //left increment becaulse for bottom left  not required for next

               left++;
               //bottom
               for(int i=left;i<=right;i++){
                   first.add(((4*n*bottom) +i+1));
               }
               //bottom -- because for right bottom is not required 

               bottom--;
               //top we can give here or above loop top -- because for right top should increment as we defined  top as 0 
               // for right top should be 1 initial 
               top++;
               //left increment because  for top row present left is not required
               left++;
               for(int i=bottom;i>=top;i--){
                   first.add(((4*n*i) +right+1));
               }
               //same here same logic
               bottom--;
               right--;
               for(int i=right;i>=left;i--){
                   first.add( ((4*n*top) +i+1));
               }
               top++;
               right--;


           }
           result.add(first);

            ArrayList<Integer> second=new ArrayList<>();
              top=0;
            bottom=nn-1;
            right=nn-1;
            left=1;
           while(top<=bottom&& left<=right){

               //left
               for(int i=bottom;i>=top;i--){

                   second.add( ((4*n*i) +right+1) );

               }
               right--;
               //bottom
               for(int i=right;i>=left;i--){
                   second.add(((4*n*top) +i+1));
               }

               top++;
               bottom--;
               right--;
               for(int i=top;i<=bottom;i++){
                   second.add(((4*n*i) +left+1));
               }
               top++;
               left++;;
               for(int i=left;i<=right;i++){
                   second.add( ((4*n*bottom) +i+1));
               }
               bottom--;
               left++;


           }

           result.add(second);


       return result;
       }   


   }