package jp.co.cyberagent.android.gpuimage;

/**
 * Applies a {@link GPUImageBoxBlurFilter} a few times (default 3) to approximate a Gaussian blur, but faster.
 *
 * @see <a href="http://stackoverflow.com/a/539117/472262">http://stackoverflow.com/a/539117/472262</a>
 * @author maikvlcek
 * @since 4:17 PM - 8/1/13
 */
public class GPUImageFastPseudoGaussianBlurFilter extends GPUImageFilterGroup {

	private float blurSize = 1f;

	public GPUImageFastPseudoGaussianBlurFilter() {
		this(1f, 3);
	}

	public GPUImageFastPseudoGaussianBlurFilter(float blurSize) {
		this(blurSize, 3);
	}

	public GPUImageFastPseudoGaussianBlurFilter(float blurSize, int samples) {
		super();
		for (int i = 0; i < samples; i++) {
			addFilter(new GPUImageBoxBlurFilter(blurSize / samples));
		}
		this.blurSize = blurSize;
	}
}
