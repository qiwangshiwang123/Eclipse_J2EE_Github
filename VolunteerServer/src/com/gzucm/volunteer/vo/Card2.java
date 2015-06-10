package com.gzucm.volunteer.vo;  
  
import java.util.ArrayList;  
import java.util.List;  
  
public class Card2 extends BaseCard2 {  
  
  
    private List<BaseCard2> mSubCards;  
  
    public Card2(Enlist enlist)   
    {  
    	super(enlist);
        mSubCards=new ArrayList<BaseCard2>();  
    }  
      
    public void AppendCard(BaseCard2 mCard)  
    {  
        mSubCards.add(mCard);  
    }  
      
    public List<BaseCard2> getSubCards()   
    {  
        return mSubCards;  
    }  
  
}  