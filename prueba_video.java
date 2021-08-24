package selenium;

public void start(@NotNull final String saveDir) {
	try {
		final GraphicsConfiguration gc = GraphicsEnvironment
			.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice()
			.getDefaultConfiguration();

		screenRecorder = new ScreenRecorder(gc,
			null,
			new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
			new Format(MediaTypeKey,
				MediaType.VIDEO,
				EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
				CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
				DepthKey, DEPTH,
				FrameRateKey, Rational.valueOf(FRAMERATE),
				QualityKey, QUALITY,
				KeyFrameIntervalKey, KEYFRAME_INTERVAL),
			new Format(MediaTypeKey,
				MediaType.VIDEO,
				EncodingKey, "black",
				FrameRateKey, Rational.valueOf(FRAME_RATE_KEY)),
			null,
			new File(saveDir));

		screenRecorder.start();
	} catch (final Exception ex) {
		LOGGER.error("Exception thrown creating or starting a screen recorder", ex);
	}
}