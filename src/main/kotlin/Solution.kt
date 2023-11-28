/** 1~100,000   k<=tangerine 의 길이
 *  1~10,000,000 tangerine의 원소 값
 *  k개를 골라, 상자 하나에 판매(단, 다른종류의 수를 최소화
 */


class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var count = k
        var map = tangerine.groupBy { it }.mapValues { it.value.size }
        var list = map.entries.sortedBy { it.value }.toMutableList()
        count = tangerine.size-k
        while(count>0){
            //정렬된 maps의 첫번쨰 value값이 0이 될떄까지 뺀다
            var n = count - list.first().value
            if(n>=0) {
                list.removeFirst()
                count = n
            }
            else break
        }
        //list의 size를 출력
        answer = list.size
        return answer
    }
}
fun main(){
    var a = Solution()
//    a.solution(6, intArrayOf(1,3,2,5,4,5,2,3))//3
//    a.solution(4, intArrayOf(1,3,2,5,4,5,2,3))//2
    a.solution(2, intArrayOf(1,1,1,1,2,2,2,3))//1
}