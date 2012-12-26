package assemblyline.common.ai;

import assemblyline.common.machine.crafter.TileEntityArmbot;

public class TaskIdle extends Task
{
	public TaskIdle(TileEntityArmbot arm)
	{
		super(arm);
	}

	protected boolean doTask()
	{
		/**
		 * randomly move the arm to similate life in the arm if the arm is powered
		 */
		return true;

	}

}
