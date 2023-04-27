package src.main.java.gb.app.modules.file;

import gb.app.domain.ReceivedFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ReceivedFileRepository extends JpaRepository<ReceivedFile, UUID> {
}
