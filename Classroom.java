public class Classroom
{
    private Desk[][] roomDesks;
    
    /**
     * Precondition: names.length <= rows*desksPerRow
     */
    public Classroom(int rows, int desksPerRow, String names[])
    {
		int studentCount = rows * desksPerRow;
		int k = 0;
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < desksPerRow; j++)
			{
				if(k < studentCount)
				{
					roomDesks[i][j] = new Desk(names[k]);;
				}
				else 
				{
					roomDesks[i][j] = new Desk(" ");
				}
				k++;
			}
		}
		
    }
	
    public Desk getDesk(int row, int col)
    {
        return roomDesks[row][col];
    }
	
    public Desk findEmptyDesk()
    {
        for (int l = 0; l < roomDesks.length; l++)
		{
			for (int m = 0; m < roomDesks[0].length; m++)
			{
				if(roomDesks[l][m].getName() == "")
				{
					return roomDesks[l][m];
				}
			}
		}
		return null;
    }

    public boolean fillDesk(Desk d, String name)
    {
        if(d.getName() != "")
		{
			return false;
		}
		else
		{
			// d.name = name;
			d.setName(name);
			return true;
		}
    }

    public void swapDesks(Desk d1, Desk d2)
    {
		String tempName1 = "";
		String tempName2 = "";
		
		tempName1 = d1.getName();
		tempName2 = d2.getName();
		d1.setName(tempName2);
		d2.setName(tempName1);

		// d1.name = setName(d2.getName());
		// d2.name = tempName;
		
		/**
		d3.name = getName(d1.name);
		d1.name = getName(d2.name);
		d2.name = getName(d3.name);
		
		d3 = d1;
		d1 = d2;
		d2 = d3; 
		**/
    }
	
    public int fixDesks()
    {
		int q = 0;
		for (int o = 0; o < roomDesks.length; o++)
		{
			for (int p = 0; p < roomDesks[0].length; p++)
			{
				if(roomDesks[o][p].getWobbles() == true)
				{
					int x = (int)(Math.random()*100+1);
					if(x <= 50) 
					{	
						roomDesks[o][p].setWobbles(true); // true, fixed desk
						q++;
					}
					else
						roomDesks[o][p].setWobbles(false); // false, unfixed desk
				}
			}
		}
		return q;
    }
	
    //MUST USE A FOR-EACH LOOP FOR CREDIT
    public String toString()
    {
        
		for (int x = 0; x < roomDesks.length; x++)
		{
			for (int y = 0; y < roomDesks[0].length; y++)
			{
				String tempWobble = "";
				roomDesks[x][y].toString();
				tempWobble = roomDesks[x][y].toString();
			}
		}
		return "";
		// int r = 0;
		// int s = 0;
		/**
		for(int[] r : roomDesks)
		{
			for(int s : r)
			{
				toString();
			}
		}
		return "";
		**/
    }

}
