class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 3; i < brown / 2; i++){
            int height = i;
            int width = ((brown - (i * 2)) / 2) + 2;
            
            if(yellow == height * width - brown && width >= height){
                answer[0] = width;
                answer[1] = height;
            }
        }
        
        return answer;
    }
}

/*
brown + yellow하면 전체 넓이가 나옴
높이를 i부터 시작하면
너비가 ((brown - (i * 2)) / 2) + 2
*/
