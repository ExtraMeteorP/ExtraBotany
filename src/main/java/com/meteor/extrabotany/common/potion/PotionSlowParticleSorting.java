package com.meteor.extrabotany.common.potion;

import com.meteor.extrabotany.common.handler.ConfigHandler;
import com.meteor.extrabotany.common.lib.LibPotionEffectName;

public class PotionSlowParticleSorting extends PotionMods{
	
	public PotionSlowParticleSorting() {
		super(ConfigHandler.idPotionSPS, LibPotionEffectName.SLOWPARTICLESORTING, false, 0x2ED3DC, 1);
	}
	
}
