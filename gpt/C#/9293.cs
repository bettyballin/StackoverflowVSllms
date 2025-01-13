using System;\nusing System.Windows.Forms;\nusing WMPLib;\n\nnamespace MediaPlayerExample\n{\n    public partial class Form1 : Form\n    {\n        private WindowsMediaPlayer mediaPlayer;\n\n        public Form1()\n        {\n            InitializeComponent();\n            mediaPlayer = new WindowsMediaPlayer();\n            mediaPlayer.PlayStateChange += MediaPlayer_PlayStateChange;\n        }\n\n        private void MediaPlayer_PlayStateChange(int NewState)\n        {\n            if ((WMPPlayState)NewState == WMPPlayState.wmppsPlaying)\n            {\n                // Player is playing\n                MessageBox.Show("The media player is playing.");\n            }\n            else if ((WMPPlayState)NewState == WMPPlayState.wmppsPaused)\n            {\n                // Player is paused\n                MessageBox.Show("The media player is paused.");\n            }\n            else if ((WMPPlayState)NewState == WMPPlayState.wmppsStopped)\n            {\n                // Player is stopped\n                MessageBox.Show("The media player is stopped.");\n            }\n        }\n\n        private void btnPlay_Click(object sender, EventArgs e)\n        {\n            mediaPlayer.URL = "path_to_your_song.wma";\n            mediaPlayer.controls.play();\n        }\n\n        private void btnCheckPosition_Click(object sender, EventArgs e)\n        {\n            double currentPosition = mediaPlayer.controls.currentPosition;\n            MessageBox.Show($"Current position: {currentPosition} seconds");\n        }\n    }\n}