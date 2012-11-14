package net.katerberg.tap.helpers;
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
import java.util.logging.Level;
import java.util.logging.Logger;

import net.katerberg.tap.TapApplication;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class SoundListeners {

	protected  Logger _logger;



	public SoundListeners() {
		_logger = Logger.getLogger("MediaListeners");
	}

	public OnErrorListener onErrorListener = new OnErrorListener() {

		public boolean onError(MediaPlayer mp, int what, int extra) {
			_logger.log(Level.FINE, "Media player issue. Probably user cancelling sound half though");
			return false;
		}
	};


	public OnCompletionListener onCompletionListener = new OnCompletionListener() {

		public void onCompletion(MediaPlayer mp) {
			//Don't do anything. This might change at some point, but I doubt it.
		}
	};

	public OnPreparedListener onPreparedListener = new OnPreparedListener() {

		public void onPrepared(MediaPlayer mp) {
			//Don't do anything. This might change at some point, but I doubt it.
		}
	};

	public OnVideoSizeChangedListener onVideoSizeChangedListener = new OnVideoSizeChangedListener() {

		public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
			//Don't do anything. This might change at some point, but I doubt it.
		}
	};



	public OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if (isChecked){
				TapApplication.setSoundOn(true);
			} else {
				TapApplication.setSoundOn(false);
			}
		}
	};
}