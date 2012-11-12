package net.katerberg.tap.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;


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
}