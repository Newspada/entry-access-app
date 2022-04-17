package com.facchinil.manager;

import com.facchinil.dto.EntryAccessDTO;
import com.facchinil.request.EntryAccessRequest;

public interface EntryAccessManager {
	
	EntryAccessDTO postEntryAccess(EntryAccessRequest request);
}
