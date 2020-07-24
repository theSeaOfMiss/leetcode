package dir.solution_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>result=new ArrayList();
        if(candidates==null||candidates.length==0)return result;
        int[]sum=new int[candidates.length];
        Arrays.sort(candidates);
        zidiedai(result,candidates,target,0,sum,-1,0);
        return result;
    }
    public static void zidiedai(List<List<Integer>>result,int[] candidates,int target,int candidatesindex,int[] sum,int sumindex,int temp)
    {
        //如果没有下一个数了，就返回
        if(candidatesindex>=candidates.length)return;


        for(int i=candidatesindex;i<candidates.length;i++)
        {
            //如果等于，则加入到result中
            if(temp+candidates[i]==target)
            {
                List<Integer>list=new ArrayList();
                for(int j=0;j<sumindex+1;j++)
                {
                    list.add(sum[j]);
                }
                list.add(candidates[i]);
                result.add(list);
                return;
            }
            //如果已经大了，那就没必要继续查找了，因为后面的更大
            else if(temp+candidates[i]>target)return;
            //如果比target还小的话
            if(sum[sumindex+1]==candidates[i])continue;
            sum[sumindex+1]=candidates[i];
            zidiedai(result,candidates,target,i+1,sum,sumindex+1,temp+candidates[i]);
        }

    }
    public static void main(String[] args) {
        combinationSum2(new int[]{1, 1, 2, 2, 2, 2}, 5);
    }
}
