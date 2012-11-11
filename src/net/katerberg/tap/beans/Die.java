package net.katerberg.tap.beans;
/*******************************************************************************
 * Copyright (c) 2012 "Mark Katerberg"
 * 
 * 
 * This file is part of TAP.
 * 
 * TAP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
public class Die {
	private Integer customDieId;
	private Integer numberOfDice;
	private Integer maxValue;
	private Integer modifier;
	

	
	public Die() {
	}
	
	public Die(Integer numberOfDice, Integer maxValue, Integer modifier) {
		this.numberOfDice = numberOfDice;
		this.maxValue = maxValue;
		this.modifier = modifier;
	}
	
	public Die(Integer customDieId, Integer numberOfDice, Integer maxValue, Integer modifier) {
		this.customDieId = customDieId;
		this.numberOfDice = numberOfDice;
		this.maxValue = maxValue;
		this.modifier = modifier;
	}

	
	
	public Integer getCustomDieId() {
		return customDieId;
	}

	public void setCustomDieId(Integer customDieId) {
		this.customDieId = customDieId;
	}

	public Integer getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(Integer numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}
	
	

}
