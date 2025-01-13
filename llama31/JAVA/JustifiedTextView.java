import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class JustifiedTextView extends TextView {

    public JustifiedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TextPaint textPaint = getPaint();
        textPaint.setColor(getCurrentTextColor());
        textPaint.drawableState = getDrawableState();
        textPaint.setTypeface(getTypeface());

        String text = getText().toString();

        int lineSpacing = getLineSpacing();
        int textWidth = getTextWidth(text);

        int start = 0;
        int end = text.indexOf('\n', start);

        while (start < text.length()) {
            if (end == -1)
                end = text.length();

            String line = text.substring(start, end);
            int width = textWidth - lineSpacing;

            int justifiedWidth = justifyText(line, width, textPaint, canvas);
            if (justifiedWidth > 0) {
                canvas.drawText(line, 0, lineSpacing, textPaint);
            }

            start = end + 1;
            end = text.indexOf('\n', start);
        }
    }

    private int justifyText(String line, int width, TextPaint textPaint, Canvas canvas) {
        float[] widths = new float[line.length()];
        textPaint.getTextWidths(line, widths);

        int totalWidth = 0;
        for (float w : widths) {
            totalWidth += w;
        }

        float spacing = (width - totalWidth) / (line.length() - 1);

        int x = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            float w = widths[i];

            canvas.drawText(String.valueOf(c), x, 0, textPaint);
            x += w + spacing;
        }

        return x;
    }

    private int getTextWidth(String text) {
        TextPaint textPaint = getPaint();
        return (int) textPaint.measureText(text);
    }

    public static void main(String[] args) {
        // Create a new instance of JustifiedTextView
        JustifiedTextView jtv = new JustifiedTextView(null, null);
        // Set some sample text
        jtv.setText("This is a sample text.\nIt should be justified.");
        // You would typically add jtv to a layout and set it as the content view of an Activity.
        // For this example, we'll just call onDraw to see the output.
        Canvas canvas = new Canvas();
        jtv.onDraw(canvas);
    }
}