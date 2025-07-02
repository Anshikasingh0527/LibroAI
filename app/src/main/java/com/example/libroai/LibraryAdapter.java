package com.example.libroai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {
    private List<Library> libraryList;

    public LibraryAdapter(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_liberary_item, parent, false);
        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
        Library library = libraryList.get(position);
        holder.bind(library);
    }

    @Override
    public int getItemCount() {
        return libraryList.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder {
        private TextView libraryName;
        private TextView libraryAddress,liberaryArea;
        private TextView libraryMobile;
        private Button joinButton;

        public LibraryViewHolder(@NonNull View itemView) {
            super(itemView);
            libraryName = itemView.findViewById(R.id.libraryName);
            libraryAddress = itemView.findViewById(R.id.libraryAddress);
            libraryMobile = itemView.findViewById(R.id.libraryMobile);
            liberaryArea =itemView.findViewById(R.id.libraryArea);
            joinButton = itemView.findViewById(R.id.enterLibraryButton);
        }

        public void bind(Library library) {
            libraryName.setText(library.getName());
            libraryAddress.setText(library.getAddress());
            libraryMobile.setText(library.getMobileNumber());

            if (library.isJoined()) {
                joinButton.setText("Joined");
                joinButton.setEnabled(false);
            } else {
                joinButton.setText("Join Library");
                joinButton.setEnabled(true);
            }

            joinButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    library.setJoined(true);
                    joinButton.setText("Joined");
                    joinButton.setEnabled(false);
                    Toast.makeText(v.getContext(), "Successfully joined " + library.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
} 