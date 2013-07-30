package jp.co.cyberagent.android.gpuimage;

/**
 * Uses image 2 as an alpha mask on image 1, where black in image 2 is full transparency in image 1
 *
 * @author maikvlcek
 * @since 11:45 AM - 7/30/13
 */
public class GPUImageAlphaMaskFilter extends GPUImageTwoInputFilter {
	public static final String ALPHA_MASK_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n" +
			" varying highp vec2 textureCoordinate2;\n" +
			"\n" +
			" uniform sampler2D inputImageTexture;\n" +
			" uniform sampler2D inputImageTexture2;\n" +
			" \n" +
			" void main()\n" +
			" {\n" +
			"   lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n" +
			"   lowp vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n" +
			"\n" +
			"   gl_FragColor = vec4(textureColor.rgb, 0.1);\n" +
			" }";

	public GPUImageAlphaMaskFilter() {
		super(ALPHA_MASK_FRAGMENT_SHADER);
	}
}