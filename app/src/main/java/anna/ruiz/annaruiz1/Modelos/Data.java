package anna.ruiz.annaruiz1.Modelos;

import java.util.List;

public class Data{
	private List<MemesItem> memes;

	public void setMemes(List<MemesItem> memes){
		this.memes = memes;
	}

	public List<MemesItem> getMemes(){
		return memes;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"memes = '" + memes + '\'' + 
			"}";
		}
}