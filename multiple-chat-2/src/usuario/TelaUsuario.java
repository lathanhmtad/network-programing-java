package usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaUsuario {
    public static JFrame window;
    public static JButton connect, sair;
    public static JTextArea textMessage;
    public static Socket socket = null;
    public static JList<String> user;

    JTextField nomeUsuario, porta, message, msgPriv;
    JButton msgPrivada, enviar;

    //main
    public static void main(String[] args) {
        new TelaUsuario();
    }

    public TelaUsuario() {
        init();
    }

    public void init() {
        window = new JFrame("Bate Papo | Nota Final");
        window.setLayout(null);
        window.setBounds(800, 200, 530, 420);
        window.setResizable(true);
        JLabel label_nomeUsuario = new JLabel("Người dùng:");
        label_nomeUsuario.setBounds(10, 28, 150, 30);
        window.add(label_nomeUsuario);

        nomeUsuario = new JTextField();
        nomeUsuario.setBounds(80, 28, 70, 30);
        window.add(nomeUsuario);

        JLabel label_porta = new JLabel("Porta:");
        label_porta.setBounds(180, 28, 50, 30);
        window.add(label_porta);

        porta = new JTextField();
        porta.setBounds(230, 28, 50, 30);
        window.add(porta);

        connect = new JButton("Nhập");
        connect.setBounds(300, 28, 90, 30);
        window.add(connect);

        sair = new JButton("Đi ra");
        sair.setBounds(400, 28, 90, 30);
        window.add(sair);

        textMessage = new JTextArea();
        textMessage.setBounds(10, 70, 340, 220);
        textMessage.setEditable(false);

        textMessage.setLineWrap(true);
        textMessage.setWrapStyleWord(true);

        JLabel label_text = new JLabel("Khu vực tin nhắn");
        label_text.setBounds(100, 58, 200, 50);
        window.add(label_text);

        JScrollPane paneText = new JScrollPane(textMessage);
        paneText.setBounds(10, 90, 360, 240);
        window.add(paneText);

        JLabel label_listaUsuario = new JLabel("Danh sách người dùng");
        label_listaUsuario.setBounds(380, 58, 200, 50);
        window.add(label_listaUsuario);

        user = new JList<String>();
        JScrollPane paneUser = new JScrollPane(user);
        paneUser.setBounds(375, 90, 140, 240);
        window.add(paneUser);

        JLabel label_Alerta = new JLabel("Nhập Mgs cho nhóm");
        label_Alerta.setBounds(10, 320, 180, 50);
        window.add(label_Alerta);

        message = new JTextField();
        message.setBounds(10, 355, 188, 30);
        message.setText(null);
        window.add(message);

        JLabel label_Aviso = new JLabel("Thêm người dùng vào tin nhắn riêng tư");
        label_Aviso.setBounds(272, 320, 250, 50);
        window.add(label_Aviso);

        msgPriv = new JTextField();
        msgPriv.setBounds(272, 355, 100, 30);
        window.add(msgPriv);

        msgPrivada = new JButton("Tin nhắn riêng");
        msgPrivada.setBounds(376, 355, 140, 30);
        window.add(msgPrivada);

        enviar = new JButton("Gửi");
        enviar.setBounds(190, 355, 77, 30);
        window.add(enviar);

        myEvent();  // add conectados/ouvindo a porta
        window.setVisible(true);
    }

    public void myEvent() {
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (socket != null && socket.isConnected()) {
                    try {
                        new UsuarioEnvia(socket, getnomeUsuario(), "3", "");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                System.exit(0);
            }
        });

        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (socket == null) {
                    JOptionPane.showMessageDialog(window, "Kết nối đã bị đóng!");
                } else if (socket != null && socket.isConnected()) {
                    try {
                        new UsuarioEnvia(socket, getnomeUsuario(), "3", "");
                        connect.setText("Entrar");
                        sair.setText("saiu!");
                        socket.close();
                        socket = null;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (socket != null && socket.isConnected()) {
                    JOptionPane.showMessageDialog(window, "Đã kết nối!");
                } else {
                    String ipString = "127.0.0.1";
                    String portaClinet = porta.getText();
                    String name = nomeUsuario.getText();

                    if ("".equals(name) || "".equals(portaClinet)) {
                        JOptionPane.showMessageDialog(window, "Người dùng hoặc cổng không thể trống!");
                    } else {
                        try {
                            int portas = Integer.parseInt(portaClinet);
                            socket = new Socket(ipString, portas);
                            connect.setText("Nhập");
                            sair.setText("sair");
                            new UsuarioEnvia(socket, getnomeUsuario(), "2", "");
                            new Thread(new UsuarioRecebe(socket)).start();
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(window, "không kết nối được, kiểm tra ip và cổng");
                        }
                    }
                }
            }
        });

        msgPrivada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarMsgmsgPriv();
            }
        });

        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarMsg();
            }
        });
    }

    public void enviarMsg() {
        String messages = message.getText();
        if ("".equals(messages)) {
            JOptionPane.showMessageDialog(window, "Không có gì để gửi");
        } else if (socket == null || !socket.isConnected()) {
            JOptionPane.showMessageDialog(window, "Không có kết nối");
        } else {
            try {
                new UsuarioEnvia(socket, getnomeUsuario() + ": " + messages, "1", "");
                message.setText(null);
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(window, "Gửi thất bại!");
            }
        }
    }

    public void enviarMsgmsgPriv() {
        String messages = message.getText();
        if ("".equals(messages)) {
            JOptionPane.showMessageDialog(window, "Không có gì để gửi!");
        } else if (socket == null || !socket.isConnected()) {
            JOptionPane.showMessageDialog(window, "Không có kết nối");
        } else {
            try {
                new UsuarioEnvia(socket, getnomeUsuario() + ": " + messages, "4", getmsgPrivada());
                TelaUsuario.textMessage.append(getnomeUsuario() + ": " + messages + "\r\n");
                message.setText(null);
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(window, "Tin nhắn riêng không được gửi!");
            }
        }
    }

    public String getnomeUsuario() {
        return nomeUsuario.getText();
    }

    public String getmsgPrivada() {
        return msgPriv.getText();
    }
}