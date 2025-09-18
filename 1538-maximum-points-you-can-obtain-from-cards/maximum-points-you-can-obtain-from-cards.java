class Solution {
    public int maxScore(int[] card, int k) {
        int max=0;
        for(int i=0;i<k;i++){
            max=max+card[i];
        }    

        if(k==card.length)  return max;

        int csum=max;
        int k1=card.length-1;
        while(k>0){
            csum=csum-card[k-1]+card[k1];
            k--;
            k1--;
            max=Math.max(max,csum);
        }

        return max;
    }
}